package ru.alina.trucking.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.alina.trucking.entities.Application;
import ru.alina.trucking.entities.Status;
import ru.alina.trucking.entities.User;
import ru.alina.trucking.entities.jpa.ApplicationRepository;
import ru.alina.trucking.exceptions.ApplicationNotFoundException;
import ru.alina.trucking.services.UserService;

@Controller
public class TruckingStaticController {

    private UserService userService;
    private ApplicationRepository applicationRepository;

    public TruckingStaticController(UserService userService,
                                    ApplicationRepository applicationRepository) {
        this.userService = userService;
        this.applicationRepository = applicationRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        String username = userService.getLoggedInUsername();
        Boolean isAdmin = userService.isAdmin(username);
        List<Application> applications = applicationRepository.findAll();
        model.addAttribute("username", username);
        model.addAttribute("admin", isAdmin);
        model.addAttribute("applications", applications);
        return "index";
    }

    @PostMapping("/")
    public String addApplication(
            Model model,
            @RequestParam Long deleteId,
            @RequestParam Long updateId) {
        String username = userService.getLoggedInUsername();
        if (deleteId != null) {
            Application application = applicationRepository.findById(deleteId)
                    .orElseThrow(() -> new ApplicationNotFoundException(String.valueOf(deleteId)));
            applicationRepository.delete(application);
        } else if (updateId != null) {
            Application application = applicationRepository.findById(updateId)
                    .orElseThrow(() -> new ApplicationNotFoundException(String.valueOf(updateId)));
            application.setStatus(Status.COMPLETED);
            applicationRepository.save(application);
        }
        List<Application> applications = applicationRepository.findAll();
        model.addAttribute("username", username);
        model.addAttribute("applications", applications);
        return "redirect:/";
    }


    @GetMapping("/application")
	public String myApplic(){

    	return "application";
	}


	@PostMapping("/application")
    public String newApplication(Model model,
                                 @RequestParam String addressFrom,
                                 @RequestParam String addressTo,
                                 @RequestParam Double volume,
                                 @RequestParam Double weight,
                                 @RequestParam String phone,
                                 @RequestParam String comment,
                                 @RequestParam String userName) {
        String username = userService.getLoggedInUsername();
        User user = userService.getUser(username);
        Application application = new Application(user, addressFrom, addressTo, weight, volume, comment, phone, userName);
        applicationRepository.save(application);
        return "redirect:/";
    }

    @GetMapping("/users")
    public String users(Model model) {
        String username = userService.getLoggedInUsername();
        List<User> users = userService.getAll();
        model.addAttribute("username", username);
        model.addAttribute("users", users);
        return "users";
    }
}
