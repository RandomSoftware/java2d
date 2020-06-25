package ru.randomsoftware.java2d.renderers;

import java.util.List;

public interface Renderer<T> {

    void render(List<List<T>> matrix);

}
