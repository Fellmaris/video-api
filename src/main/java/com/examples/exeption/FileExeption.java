package com.examples.exeption;

import lombok.Getter;

@Getter
public class FileExeption extends RuntimeException{

        private final String message;

        public FileExeption(String message) {
            this.message = message;
        }
    }