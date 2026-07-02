package com.keneya.kolochili.IService;

import java.util.List;

import com.keneya.kolochili.DTO.Request.CategorieActiviteDTORequest;
import com.keneya.kolochili.DTO.Response.CategorieActiviteDTOResponse;

public interface ICategorieActiviteService extends IService<CategorieActiviteDTORequest, Long, CategorieActiviteDTOResponse> {
    
    List<CategorieActiviteDTOResponse> getAllCategories();
    
    CategorieActiviteDTOResponse getCategoryById(Long id);
    
    CategorieActiviteDTOResponse createCategory(CategorieActiviteDTORequest request);
    
    CategorieActiviteDTOResponse updateCategory(Long id, CategorieActiviteDTORequest request);
    
    void deleteCategory(Long id);
    
    List<CategorieActiviteDTOResponse> getActiveCategories();
}