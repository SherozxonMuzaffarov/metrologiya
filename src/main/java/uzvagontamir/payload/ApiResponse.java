package uzvagontamir.payload;

import uzvagontamir.model.TransportModel;

public class ApiResponse {
    private String message;
    private TransportModel transportModel;
    private boolean success;

    public ApiResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    public ApiResponse(TransportModel transportModel, boolean success) {
        this.transportModel = transportModel;
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public TransportModel getTransportModel() {
        return transportModel;
    }

    public void setTransportModel(TransportModel transportModel) {
        this.transportModel = transportModel;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
