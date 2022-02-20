package com.mindsoft.immobilierproject.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.http.fileupload.impl.FileSizeLimitExceededException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.mindsoft.immobilierproject.model.Profile;
import com.mindsoft.immobilierproject.model.Propriete;
import com.mindsoft.immobilierproject.repository.ProfileRepository;
import com.mindsoft.immobilierproject.service.ProfileServiceImpl;

@Controller
public class ProfileController {

	@Autowired 
	private ProfileServiceImpl profileService;
	
	@Autowired
	private ProfileRepository profileRepository;
	
	public static String profile;
	
	@GetMapping("/profile")
	public String profileProfessionnel() {
		return "profile";
	}
		
	@GetMapping("/addProfile")
	public String addProfiles(Model model) {
		return "/ajouterProfile";
	}
	
	@RequestMapping(value = "/addProfile", method = RequestMethod.POST)
    public RedirectView saveProfile(Profile profile,  @RequestParam("file") MultipartFile multipartFile,  Exception exc, 
    		Model model) throws IOException{
	
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        profile.setPhoto(fileName);
       //profileService.addProfile(profile);
       Profile savedProfile = profileService.addProfile(profile);
       
       String uploadDir = "user-photos/" + savedProfile.getId();
       
       Path uploadPath = Paths.get(uploadDir);
       
       if(!Files.exists(uploadPath)) {
    	   Files.createDirectories(uploadPath);
       }
       
       try (InputStream inputStream = multipartFile.getInputStream()) {
           Path filePath = uploadPath.resolve(fileName);
           System.out.println(filePath.toFile().getAbsolutePath());
           Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
       } catch (IOException ioe) { 
    	   
           throw new IOException("Could not save image file: " + fileName, ioe);
       }   
       if (exc instanceof FileSizeLimitExceededException) {
    	   model.addAttribute("messageFileExceed", "File size exceeds limit!");
       }
//       FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
       
        return new RedirectView ("/addProfile", true);
    }
	
    @RequestMapping(value = "/mesProfiles", method = RequestMethod.GET)
    public String listProfile(Model model) {
        List<Profile> listProfiles = profileService.findByProprieteaire();
        model.addAttribute("profiles", listProfiles);
        
        return "professionnel";
    }
    
    @RequestMapping(value = "/profile/{id}", method = RequestMethod.GET)
    public String productDetail(@PathVariable("id") Long id, Model model) {

        Optional<Profile> profile = profileRepository.findById(id);
        		

        model.addAttribute("hisProfile", profile);

        System.out.println("teste: " + id);

        return "profile";
    }
    
    @RequestMapping(value = "/professionnels", method = RequestMethod.GET)
    public String listProfiles(Model model) {
        List<Profile> listProfiles = profileService.findAll();
        model.addAttribute("profiless", listProfiles);
        
        return "homeProfessionnel";
    }
    
    @RequestMapping("profiles/findById")
	@ResponseBody
	public Optional<Profile> findById(Long id) {
		return profileService.findById(id);
	}
    
    @RequestMapping(value = "/profileDetail/{id}", method = RequestMethod.GET)
    public ModelAndView profileDetail(@PathVariable("id") Long id, Model model) {

        Optional<Profile> profile = profileRepository.findById(id);

        model.addAttribute("profiile", profile);

        System.out.println("teste: " + id);

        return new ModelAndView("redirect:/profile");
    }
    
//    @PostMapping("/saveEmployee")
//    public ModelAndView saveEmployee(@ModelAttribute Employee employee) {
//        service.saveEmployee(employee);
//        return new ModelAndView("redirect:/");
//    }
    
    @RequestMapping(value="/profile/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Profile profile) {
    	profileRepository.save(profile);
		return "redirect:/professionnel";
	}
    
    @GetMapping("/deleteProfile/{id}")
    public String deleteProfile(@PathVariable("id") Long id) {
    	profileRepository.deleteById(id);
    	return "redirect:/professionnel";
    }
	
	
}
