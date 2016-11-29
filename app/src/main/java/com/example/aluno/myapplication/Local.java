package com.example.aluno.myapplication;

import java.io.Serializable;

/**
 * Created by aluno on 14/11/16.
 */

public class Local implements Serializable{
    private int id;
    private String nome;
    private Double latitude;
        private Double longitude;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public Double getLatitude() {
            return latitude;
        }

        public void setLatitude(Double latitude) {
            this.latitude = latitude;
        }

        public Double getLongitude() {
            return longitude;
        }

        public void setLongitude(Double longitude) {
            this.longitude = longitude;
        }

        @Override
        public String toString() {
            return this.getNome();
        }
    }
