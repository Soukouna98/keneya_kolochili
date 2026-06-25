package com.keneya.kolochili.DTO;


import lombok.Data;


    @Data
    public class PublicationDTO {

    private Long id;

    private Long agentId;

    private String nomMaladie;

    private String symptome;

    private String conseilPreventif;

    private String sources;
    private boolean archive;
}


