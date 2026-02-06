package com.shivamdenge.NeonAi.dto.project;

public record FileNodeDTO(
        String path
) {

    @Override
    public String toString() {
        return path;
    }
}
