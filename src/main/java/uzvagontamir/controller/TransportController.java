package uzvagontamir.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uzvagontamir.ModelDto.TransportModelDto;
import uzvagontamir.model.TransportModel;
import uzvagontamir.payload.ApiResponse;
import uzvagontamir.service.TransportService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


@Controller
public class TransportController {

    @Autowired
    TransportService transportService;

    // hammasini olish
    @PreAuthorize(value = "hasAnyRole('DIRECTOR','SAMTRANSPORT','HAVTRANSPORT','ANDJTRANSPORT')")
    @GetMapping("/")
    public String listTransport() {
        return "main";
    }

    // hammasini olish
    @PreAuthorize(value = "hasAnyRole('DIRECTOR','SAMTRANSPORT','HAVTRANSPORT','ANDJTRANSPORT')")
    @GetMapping("/transport")
    public String listTransport(Model model,HttpServletRequest request) {
        if (request.isUserInRole("DIRECTOR")) {
            model.addAttribute("transports", transportService.findAll());
            model.addAttribute("isAdmin", true);
        }else if (request.isUserInRole("SAMTRANSPORT")) {
            model.addAttribute("transports", transportService.findAllByDepoNomi("VCHD-6"));
        }else if (request.isUserInRole("HAVTRANSPORT")) {
            model.addAttribute("transports", transportService.findAllByDepoNomi("VCHD-3"));
        }else if (request.isUserInRole("ANDJTRANSPORT")) {
            model.addAttribute("transports", transportService.findAllByDepoNomi("VCHD-5"));
        }

        return "transport";
    }

    //template qoshish uchun oyna
    @PreAuthorize(value = "hasAnyRole('DIRECTOR','SAMTRANSPORT','HAVTRANSPORT','ANDJTRANSPORT')")
    @GetMapping("/transport/newTransport")
    public String createForm(Model model) {
        model.addAttribute("transportModel",  new TransportModel());
        return "create_transport";
    }

    //template qoshish
    @PreAuthorize(value = "hasAnyRole('DIRECTOR','SAMTRANSPORT','HAVTRANSPORT','ANDJTRANSPORT')")
    @PostMapping("/transport/saveTransport")
    public String saveTransport(@ModelAttribute("transportModel") @Valid TransportModelDto transportModel, HttpServletRequest request, Model model ) {
        if (transportModel.getNomeri().equalsIgnoreCase("") || transportModel.getRusumi() == null){
            model.addAttribute("message", "Davlat raqami va rusimi bo'sh bo'lishi mumkin emas");
            model.addAttribute("isSuccess", false);
        }

        if (request.isUserInRole("DIRECTOR")) {
            ApiResponse apiResponse = transportService.saveTransport(transportModel);
            model.addAttribute("message", apiResponse.getMessage());
            model.addAttribute("isSuccess", apiResponse.isSuccess());
            model.addAttribute("transports", transportService.findAll());
            model.addAttribute("isAdmin", true);
        }else if (request.isUserInRole("SAMTRANSPORT")) {
            ApiResponse apiResponse = transportService.saveTransportSam(transportModel);
            model.addAttribute("message", apiResponse.getMessage());
            model.addAttribute("isSuccess", apiResponse.isSuccess());
            model.addAttribute("transports", transportService.findAllByDepoNomi("VCHD-6"));
        }else if (request.isUserInRole("HAVTRANSPORT")) {
            ApiResponse apiResponse = transportService.saveTransportHav(transportModel);
            model.addAttribute("message", apiResponse.getMessage());
            model.addAttribute("isSuccess", apiResponse.isSuccess());
            model.addAttribute("transports", transportService.findAllByDepoNomi("VCHD-3"));
        }else if (request.isUserInRole("ANDJTRANSPORT")) {
            ApiResponse apiResponse = transportService.saveTransportAndj(transportModel);
            model.addAttribute("message", apiResponse.getMessage());
            model.addAttribute("isSuccess", apiResponse.isSuccess());
            model.addAttribute("transports", transportService.findAllByDepoNomi("VCHD-5"));
        }
        
        return "transport";
    }

    //tahrirlash uchun oyna
    @PreAuthorize(value = "hasAnyRole('DIRECTOR','SAMTRANSPORT','HAVTRANSPORT','ANDJTRANSPORT')")
    @GetMapping("/transport/edit/{id}")
    public String editTransportForm(@PathVariable("id") Integer id, Model model, HttpServletRequest request) {

        TransportModel transportModel = transportService.findById(id);

        if (request.isUserInRole("SAMTRANSPORT")) {
           if (!transportModel.getDepoNomi().equalsIgnoreCase("VCHD-6")) {
               model.addAttribute("message", "Siz faqat VCHD-6 dagi transport ma'lumotlarini o'zgartirishingiz mumkin");
               model.addAttribute("isSuccess", false);
               
               model.addAttribute("transports", transportService.findAll());
               return "transport";
           }
        }else if (request.isUserInRole("HAVTRANSPORT")) {
            if (!transportModel.getDepoNomi().equalsIgnoreCase("VCHD-3")) {
                model.addAttribute("message", "Siz faqat VCHD-3 dagi transport ma'lumotlarini o'zgartirishingiz mumkin");
                model.addAttribute("isSuccess", false);
                model.addAttribute("transports", transportService.findAll());

                return "transport";
            }
        }else if (request.isUserInRole("ANDJTRANSPORT")) {
            if (!transportModel.getDepoNomi().equalsIgnoreCase("VCHD-5")) {
                model.addAttribute("message", "Siz faqat VCHD-5 dagi transport ma'lumotlarini o'zgartirishingiz mumkin");
                model.addAttribute("isSuccess", false);
                model.addAttribute("transports", transportService.findAll());
                return "transport";
            }
        }

        model.addAttribute("transport", transportModel);

        return "edit_transport";
    }
    
    //tahrirni saqlash
    @PreAuthorize(value = "hasAnyRole('DIRECTOR','SAMTRANSPORT','HAVTRANSPORT','ANDJTRANSPORT')")
    @PostMapping("/transport/update/{id}")
    public String updateVagon(@ModelAttribute("vagon") @Valid TransportModelDto transport, @PathVariable Integer id,Model model, HttpServletRequest request) {
        if (transport.getNomeri() == null || transport.getRusumi() == null){
            model.addAttribute("message", "Davlat raqami va rusimi bo'sh bo'lishi mumkin emas");
            model.addAttribute("isSuccess", false);
        }

        if (request.isUserInRole("DIRECTOR")) {
            ApiResponse apiResponse = transportService.updateTransport(transport, id);
            model.addAttribute("message", apiResponse.getMessage());
            model.addAttribute("isSuccess", apiResponse.isSuccess());
            model.addAttribute("transports", transportService.findAll());
            model.addAttribute("isAdmin", true);
        }else if (request.isUserInRole("SAMTRANSPORT")) {
            ApiResponse apiResponse = transportService.updateTransportSam(transport, id);
            model.addAttribute("message", apiResponse.getMessage());
            model.addAttribute("isSuccess", apiResponse.isSuccess());
            model.addAttribute("transports", transportService.findAllByDepoNomi("VCHD-6"));
        }else if (request.isUserInRole("HAVTRANSPORT")) {
            ApiResponse apiResponse = transportService.updateTransportHav(transport, id);
            model.addAttribute("message", apiResponse.getMessage());
            model.addAttribute("isSuccess", apiResponse.isSuccess());
            model.addAttribute("transports", transportService.findAllByDepoNomi("VCHD-3"));
        }else if (request.isUserInRole("ANDJTRANSPORT")) {
            ApiResponse apiResponse = transportService.updateTransportAndj(transport, id);
            model.addAttribute("message", apiResponse.getMessage());
            model.addAttribute("isSuccess", apiResponse.isSuccess());
            model.addAttribute("transports", transportService.findAllByDepoNomi("VCHD-5"));
        }



        return "transport";
    }

    //bazadan o'chirish
    @PreAuthorize(value = "hasAnyRole('DIRECTOR','SAMTRANSPORT','HAVTRANSPORT','ANDJTRANSPORT')")
    @GetMapping("/transport/delete/{id}")
    public String deleteVagonForm(@PathVariable("id") Integer id, HttpServletRequest request,Model model ) {
        if (request.isUserInRole("DIRECTOR")) {
            ApiResponse apiResponse = transportService.deleteTransportById(id);
            model.addAttribute("message", apiResponse.getMessage());
            model.addAttribute("isSuccess", apiResponse.isSuccess());
            model.addAttribute("transports", transportService.findAll());
            model.addAttribute("isAdmin", true);
        }else if (request.isUserInRole("SAMTRANSPORT")) {
            ApiResponse apiResponse = transportService.deleteTransportSam(id);
            model.addAttribute("message", apiResponse.getMessage());
            model.addAttribute("isSuccess", apiResponse.isSuccess());
            model.addAttribute("transports", transportService.findAllByDepoNomi("VCHD-6"));
        }else if (request.isUserInRole("HAVTRANSPORT")) {
            ApiResponse apiResponse = transportService.deleteTransportHav(id);
            model.addAttribute("message", apiResponse.getMessage());
            model.addAttribute("isSuccess", apiResponse.isSuccess());
            model.addAttribute("transports", transportService.findAllByDepoNomi("VCHD-3"));
        }else if (request.isUserInRole("ANDJTRANSPORT")) {
            ApiResponse apiResponse = transportService.deleteTransportAndj(id);
            model.addAttribute("message", apiResponse.getMessage());
            model.addAttribute("isSuccess", apiResponse.isSuccess());
            model.addAttribute("transports", transportService.findAllByDepoNomi("VCHD-5"));
        }

        return "transport";
    }

    @PreAuthorize(value = "hasAnyRole('DIRECTOR','SAMTRANSPORT','HAVTRANSPORT','ANDJTRANSPORT')")
    @GetMapping("/transport/filter")
    public String filter(Model model, HttpServletRequest request,  @RequestParam(value = "depoNomi") String depoNomi ) {

        if (request.isUserInRole("DIRECTOR")) {
            if (!depoNomi.equalsIgnoreCase("Jami")) {
                model.addAttribute("transports", transportService.findAllByDepoNomi(depoNomi));
            } else {
                model.addAttribute("transports", transportService.findAll());
            }
            model.addAttribute("isAdmin", true);
        }

        return "transport";
    }
}
