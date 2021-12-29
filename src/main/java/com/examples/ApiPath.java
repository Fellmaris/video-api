package com.examples;

public interface ApiPath {
    String ID_VARIABLE = "id";
    String NAME_VARIABLE = "name";

    String VIDEOS = "/videos";
    String VIDEO = "/{" + ID_VARIABLE + "}";
    String SEARCH = "/search";
    String FILES = "/files";
    String FILE_BY_NAME = "/{" + NAME_VARIABLE + "}";
    String LOGIN = "/login";
}
