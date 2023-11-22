package com.example.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApiService {

    @Autowired
    ApiRepository apiRepository;

    public List<ApiEntity> getAllApiEntities() {
        return (List<ApiEntity>) apiRepository.findAll();
    }

    public ApiEntity createApiEntity(ApiModelService apiModel) {
        ApiEntity apiEntity = new ApiEntity();
        apiEntity.setServiceName(apiModel.getServiceName());
        apiEntity.setPortNumber(apiModel.getPortNumber());
        return apiRepository.save(apiEntity);
    }

    public Optional<ApiEntity> getApiEntityById(Integer id) {
        return apiRepository.findById(id);
    }
    
    public ApiEntity updateApiEntity(Integer id, ApiModelService apiModel) {
        Optional<ApiEntity> optionalApiEntity = apiRepository.findById(id);

        // ApiEntity returnValue = new ApiEntity();

        if (optionalApiEntity.isPresent()) {
            ApiEntity apiEntity = optionalApiEntity.get();
            apiEntity.setServiceName(apiModel.getServiceName());
            apiEntity.setPortNumber(apiModel.getPortNumber());
            return apiRepository.save(apiEntity);
        } else {
            // returnValue.setStatus(-1);
            // returnValue.setMessage("Unable to create manually alert");
            // returnValue.setMessageDetail("Contact with administrator");
            // logger.error(returnValue.getMessageDetail());
            return null;
        }
    }

    public String deleteApiEntity(Integer id) {
        apiRepository.deleteById(id);

        return "Data has been Deleted";
    }
    
}
