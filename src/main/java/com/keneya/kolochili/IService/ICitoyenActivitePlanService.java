package com.keneya.kolochili.IService;

import java.util.List;

import com.keneya.kolochili.DTO.Request.CitoyenActivitePlanDTORequest;
import com.keneya.kolochili.DTO.Response.CitoyenActivitePlanDTOResponse;

public interface ICitoyenActivitePlanService {

    CitoyenActivitePlanDTOResponse create(
            CitoyenActivitePlanDTORequest dto);

    CitoyenActivitePlanDTOResponse getById(Long id);

    List<CitoyenActivitePlanDTOResponse> getAll();

    void delete(Long id);

    CitoyenActivitePlanDTOResponse update(
        Long id, CitoyenActivitePlanDTORequest dto);
    }