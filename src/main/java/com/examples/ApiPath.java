package com.examples;

public interface ApiPath {
    String ID_VARIABLE = "id";
    String ROOT = "/api";
    String VIDEOS = "/videos";
    String VIDEO = "/{" + ID_VARIABLE + "}";
    String SEARCH = "/search";
}
