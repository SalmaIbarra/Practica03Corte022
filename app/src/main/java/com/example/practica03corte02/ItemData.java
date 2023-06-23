package com.example.practica03corte02;

public class ItemData {
    private String txtNombre;
    private String txtMatricula;
    private Integer imageId;
    public ItemData(String text, String text2, Integer imageId){
        this.txtNombre = text;
        this.txtMatricula = text2;
        this.imageId =imageId;
    }
//Item Alumno
    public String getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(String txtNombre) {
        this.txtNombre = txtNombre;
    }

    public String getTxtMatricula() {
        return txtMatricula;
    }

    public void setTxtMatricula(String txtMatricula) {
        this.txtMatricula = txtMatricula;
    }

    public Integer getImageId(){
        return imageId;
    }
    public void setImageId(Integer imageId){
        this.imageId = imageId;
    }
}
