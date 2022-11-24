package uzvagontamir.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uzvagontamir.ModelDto.TransportModelDto;
import uzvagontamir.model.TransportModel;
import uzvagontamir.payload.ApiResponse;
import uzvagontamir.repository.TransportRepository;
import uzvagontamir.service.TransportService;

import java.util.List;
import java.util.Optional;

@Service
public class TransportServiceImpl implements TransportService {

    @Autowired
    TransportRepository transportRepository;

    @Override
    public List<TransportModel> findAll() {
        return transportRepository.findAll();
    }

    @Override
    public ApiResponse saveTransport(TransportModelDto transportModel) {
        TransportModel model = new TransportModel();
        model.setRusumi(transportModel.getRusumi());
        model.setNomeri(transportModel.getNomeri());
        model.setYili(transportModel.getYili());
        model.setTexMuddati(transportModel.getTexMuddati());
        model.setGazMuddati(transportModel.getGazMuddati());
        model.setSugurta(transportModel.getSugurta());
        model.setYoqilgiTuri(transportModel.getYoqilgiTuri());
        model.setDepoNomi(transportModel.getDepoNomi());
        model.setHolati(transportModel.getHolati());
        model.setIzoh(transportModel.getIzoh());

        transportRepository.save(model);
        return new ApiResponse("Davlat raqami " + model.getNomeri() + " bo'lgan transport saqlandi", true);
    }

    @Override
    public ApiResponse saveTransportSam(TransportModelDto transportModel) {
        if (transportModel.getDepoNomi().equalsIgnoreCase("VCHD-6")){

            TransportModel model = new TransportModel();
            model.setRusumi(transportModel.getRusumi());
            model.setNomeri(transportModel.getNomeri());
            model.setYili(transportModel.getYili());
            model.setTexMuddati(transportModel.getTexMuddati());
            model.setGazMuddati(transportModel.getGazMuddati());
            model.setSugurta(transportModel.getSugurta());
            model.setYoqilgiTuri(transportModel.getYoqilgiTuri());
            model.setDepoNomi(transportModel.getDepoNomi());
            model.setHolati(transportModel.getHolati());
            model.setIzoh(transportModel.getIzoh());

            transportRepository.save(model);
            return new ApiResponse("Davlat raqami " + model.getNomeri() + " bo'lgan transport saqlandi", true);
        }
        else
            return new ApiResponse("Siz faqat VCHD-6 ga ma'lumot qo'shishingiz mumkin ", false);
    }

    @Override
    public ApiResponse saveTransportHav(TransportModelDto transportModel) {
        if (transportModel.getDepoNomi().equalsIgnoreCase("VCHD-3")){

            TransportModel model = new TransportModel();
            model.setRusumi(transportModel.getRusumi());
            model.setNomeri(transportModel.getNomeri());
            model.setYili(transportModel.getYili());
            model.setTexMuddati(transportModel.getTexMuddati());
            model.setGazMuddati(transportModel.getGazMuddati());
            model.setSugurta(transportModel.getSugurta());
            model.setYoqilgiTuri(transportModel.getYoqilgiTuri());
            model.setDepoNomi(transportModel.getDepoNomi());
            model.setHolati(transportModel.getHolati());
            model.setIzoh(transportModel.getIzoh());

            transportRepository.save(model);
            return new ApiResponse("Davlat raqami " + model.getNomeri() + " bo'lgan transport saqlandi", true);
        }
        else
            return new ApiResponse("Siz faqat VCHD-3 ga ma'lumot qo'shishingiz mumkin ", false);
    }

    @Override
    public ApiResponse saveTransportAndj(TransportModelDto transportModel) {
        if (transportModel.getDepoNomi().equalsIgnoreCase("VCHD-5")){

            TransportModel model = new TransportModel();
            model.setRusumi(transportModel.getRusumi());
            model.setNomeri(transportModel.getNomeri());
            model.setYili(transportModel.getYili());
            model.setTexMuddati(transportModel.getTexMuddati());
            model.setGazMuddati(transportModel.getGazMuddati());
            model.setSugurta(transportModel.getSugurta());
            model.setYoqilgiTuri(transportModel.getYoqilgiTuri());
            model.setDepoNomi(transportModel.getDepoNomi());
            model.setHolati(transportModel.getHolati());
            model.setIzoh(transportModel.getIzoh());

            transportRepository.save(model);
            return new ApiResponse("Davlat raqami " + model.getNomeri() + " bo'lgan transport saqlandi", true);
        }
        else
            return new ApiResponse("Siz faqat VCHD-5 ga ma'lumot qo'shishingiz mumkin ", false);
    }

    @Override
    public TransportModel findById(Integer id) {
        Optional<TransportModel> optionalTransport = transportRepository.findById(id);
        return optionalTransport.orElse(null);
    }

    @Override
    public ApiResponse updateTransport(TransportModelDto transportModel, Integer id) {
        Optional<TransportModel> optionalTransport = transportRepository.findById(id);
        if (!optionalTransport.isPresent())
            return new ApiResponse("Bajarilmadi", false);
        TransportModel savedTransport = optionalTransport.get();
        savedTransport.setId(id);
        savedTransport.setNomeri(transportModel.getNomeri());
        savedTransport.setRusumi(transportModel.getRusumi());
        savedTransport.setDepoNomi(transportModel.getDepoNomi());
        savedTransport.setYili(transportModel.getYili());
        savedTransport.setTexMuddati(transportModel.getTexMuddati());
        savedTransport.setSugurta(transportModel.getSugurta());
        savedTransport.setGazMuddati(transportModel.getGazMuddati());
        savedTransport.setYoqilgiTuri(transportModel.getYoqilgiTuri());
        savedTransport.setHolati(transportModel.getHolati());
        savedTransport.setIzoh(transportModel.getIzoh());

        transportRepository.save(savedTransport);

        return new ApiResponse("Muvaffaqiyatli bajarildi", true);
    }

    @Override
    public ApiResponse updateTransportSam(TransportModelDto transportModel, Integer id) {
        Optional<TransportModel> optionalTransport = transportRepository.findById(id);
        if (!optionalTransport.isPresent())
            return new ApiResponse("Bajarilmadi", false);
        TransportModel savedTransport = optionalTransport.get();
        if (!transportModel.getDepoNomi().equalsIgnoreCase("VCHD-6"))
            return new ApiResponse("Siz faqat VCHD-6 ga ma'lumot kiritishingiz mumkin", false);
        savedTransport.setId(id);
        savedTransport.setNomeri(transportModel.getNomeri());
        savedTransport.setRusumi(transportModel.getRusumi());
        savedTransport.setDepoNomi(transportModel.getDepoNomi());
        savedTransport.setYili(transportModel.getYili());
        savedTransport.setTexMuddati(transportModel.getTexMuddati());
        savedTransport.setSugurta(transportModel.getSugurta());
        savedTransport.setGazMuddati(transportModel.getGazMuddati());
        savedTransport.setYoqilgiTuri(transportModel.getYoqilgiTuri());
        savedTransport.setHolati(transportModel.getHolati());
        savedTransport.setIzoh(transportModel.getIzoh());

        transportRepository.save(savedTransport);

        return new ApiResponse("Muvaffaqiyatli bajarildi", true);
    }

    @Override
    public ApiResponse updateTransportHav(TransportModelDto transportModel, Integer id) {
        Optional<TransportModel> optionalTransport = transportRepository.findById(id);
        if (!optionalTransport.isPresent())
            return new ApiResponse("Bajarilmadi", false);
        TransportModel savedTransport = optionalTransport.get();
        if (!transportModel.getDepoNomi().equalsIgnoreCase("VCHD-3") )
            return new ApiResponse("Siz faqat VCHD-6 ga ma'lumot kiritishingiz mumkin", false);
        savedTransport.setId(id);
        savedTransport.setNomeri(transportModel.getNomeri());
        savedTransport.setRusumi(transportModel.getRusumi());
        savedTransport.setDepoNomi(transportModel.getDepoNomi());
        savedTransport.setYili(transportModel.getYili());
        savedTransport.setTexMuddati(transportModel.getTexMuddati());
        savedTransport.setSugurta(transportModel.getSugurta());
        savedTransport.setGazMuddati(transportModel.getGazMuddati());
        savedTransport.setYoqilgiTuri(transportModel.getYoqilgiTuri());
        savedTransport.setHolati(transportModel.getHolati());
        savedTransport.setIzoh(transportModel.getIzoh());

        transportRepository.save(savedTransport);

        return new ApiResponse("Muvaffaqiyatli bajarildi", true);
    }

    @Override
    public ApiResponse updateTransportAndj(TransportModelDto transportModel, Integer id) {
        Optional<TransportModel> optionalTransport = transportRepository.findById(id);
        if (!optionalTransport.isPresent())
            return new ApiResponse("Bajarilmadi", false);
        TransportModel savedTransport = optionalTransport.get();
        if (!transportModel.getDepoNomi().equalsIgnoreCase("VCHD-5"))
            return new ApiResponse("Siz faqat VCHD-6 ga ma'lumot kiritishingiz mumkin", false);
        savedTransport.setId(id);
        savedTransport.setNomeri(transportModel.getNomeri());
        savedTransport.setRusumi(transportModel.getRusumi());
        savedTransport.setDepoNomi(transportModel.getDepoNomi());
        savedTransport.setYili(transportModel.getYili());
        savedTransport.setTexMuddati(transportModel.getTexMuddati());
        savedTransport.setSugurta(transportModel.getSugurta());
        savedTransport.setGazMuddati(transportModel.getGazMuddati());
        savedTransport.setYoqilgiTuri(transportModel.getYoqilgiTuri());
        savedTransport.setHolati(transportModel.getHolati());
        savedTransport.setIzoh(transportModel.getIzoh());

        transportRepository.save(savedTransport);

        return new ApiResponse("Muvaffaqiyatli bajarildi", true);
    }

    @Override
    public ApiResponse deleteTransportById(Integer id) {
        TransportModel transportModel = transportRepository.findById(id).get();
        transportRepository.deleteById(id);
        return new ApiResponse("Davlat raqami " + transportModel.getNomeri() + " bo'lgan transport o'chirildi",true);
    }

    @Override
    public ApiResponse deleteTransportSam(Integer id) {
        TransportModel transportModel = transportRepository.findById(id).get();
        if (!transportModel.getDepoNomi().equalsIgnoreCase("VCHD-6"))
            return new ApiResponse("Siz faqat VCHD-6 dagi ma'lumotlarni o'chirishingiz mumkin", false);
        transportRepository.deleteById(id);
        return new ApiResponse("Davlat raqami " + transportModel.getNomeri() + " bo'lgan transport o'chirildi",true);
    }

    @Override
    public ApiResponse deleteTransportHav(Integer id) {
        TransportModel transportModel = transportRepository.findById(id).get();
        if (!transportModel.getDepoNomi().equalsIgnoreCase("VCHD-3"))
            return new ApiResponse("Siz faqat VCHD-3 dagi ma'lumotlarni o'chirishingiz mumkin", false);
        transportRepository.deleteById(id);
        return new ApiResponse("Davlat raqami " + transportModel.getNomeri() + " bo'lgan transport o'chirildi",true);
    }

    @Override
    public ApiResponse deleteTransportAndj(Integer id) {
        TransportModel transportModel = transportRepository.findById(id).get();
        if (!transportModel.getDepoNomi().equalsIgnoreCase("VCHD-5"))
            return new ApiResponse("Siz faqat VCHD-5 dagi ma'lumotlarni o'chirishingiz mumkin", false);
        transportRepository.deleteById(id);
        return new ApiResponse("Davlat raqami " + transportModel.getNomeri() + " bo'lgan transport o'chirildi",true);
    }

    @Override
    public List<TransportModel> findAllByDepoNomi(String depoNomi) {
        return transportRepository.findByDepoNomi(depoNomi);
    }
}
