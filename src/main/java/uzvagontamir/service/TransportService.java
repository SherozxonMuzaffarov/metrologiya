package uzvagontamir.service;

import uzvagontamir.ModelDto.TransportModelDto;
import uzvagontamir.model.TransportModel;
import uzvagontamir.payload.ApiResponse;

import java.util.List;

public interface TransportService {
    List<TransportModel> findAll();

    ApiResponse saveTransport(TransportModelDto transportModel);

    ApiResponse saveTransportSam(TransportModelDto transportModel);

    ApiResponse saveTransportHav(TransportModelDto transportModel);

    ApiResponse saveTransportAndj(TransportModelDto transportModel);

    TransportModel findById(Integer id);

    ApiResponse updateTransport(TransportModelDto transportModel, Integer id);

    ApiResponse updateTransportSam(TransportModelDto transportModel, Integer id);

    ApiResponse updateTransportHav(TransportModelDto transportModel, Integer id);

    ApiResponse updateTransportAndj(TransportModelDto transportModel, Integer id);

    ApiResponse deleteTransportById(Integer id);

    ApiResponse deleteTransportSam(Integer id);

    ApiResponse deleteTransportHav(Integer id);

    ApiResponse deleteTransportAndj(Integer id);

    List<TransportModel> findAllByDepoNomi(String depoNomi);
}
