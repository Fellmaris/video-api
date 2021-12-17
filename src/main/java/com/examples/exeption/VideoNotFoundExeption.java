package com.examples.exeption;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class VideoNotFoundExeption extends RuntimeException {
    private final UUID id;
}
