package com.epam.homework.task27;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Task27Impl implements Task27 {

    /**
     * Реализовать класс Graph, представляющий собой неориентированный граф (между двумя вершинами допустимо максимум одно ребро).
     * Методы должны поддерживать быстрое добавление и удаление ребер.
     *
     * @param numberNodes Количество вершин в графе.
     * @return Граф указанной конфигурации.
     */
    @Override
    public AbstractGraph createGraph(int numberNodes) {
        return new Graph(numberNodes);
    }

    class Graph extends AbstractGraph {

        private byte[][] edges = new byte[NUMBER_NODES][NUMBER_NODES];

        Graph(int numberNodes) {
            super(numberNodes);
        }

        @Override
        public void addEdge(int first, int second) {
            if ((first < NUMBER_NODES) && (second < NUMBER_NODES)) {
                edges[first][second] = 1;
                edges[second][first] = 1;
            }
        }

        @Override
        public void removeEdge(int first, int second) {
            edges[first][second] = 0;
            edges[second][first] = 0;
        }

        @Override
        public boolean isEdgeExists(int first, int second) {
            return edges[first][second] == 1;
        }
    }
}
