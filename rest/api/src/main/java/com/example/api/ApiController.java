package com.example.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@ResponseBody
@RestController
public class ApiController {
    
    @Autowired
    ApiService apiService;
    
    // @Autowired
    // ApiRepository apiRepository;

    @GetMapping("/entities")
    public List<ApiEntity> getAllEntities() {
        return apiService.getAllApiEntities();
    }

    @PostMapping("/create")
    public ApiEntity createApi(@RequestBody ApiModelService apiModel) {
        return apiService.createApiEntity(apiModel);
    }

    @GetMapping("/entity/{id}")
    public Optional<ApiEntity> getEntityById(@PathVariable Integer id) {
        return apiService.getApiEntityById(id);
    }

    @PutMapping("/update/{id}")
    public ApiEntity updateEntity(@PathVariable Integer id, @RequestBody ApiModelService apiModel) {
        return apiService.updateApiEntity(id, apiModel);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEntity(@PathVariable Integer id) {
        return apiService.deleteApiEntity(id);
    }


}
