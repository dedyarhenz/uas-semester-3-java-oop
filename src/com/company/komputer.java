package com.company;

public abstract class komputer {
    private String nama_komputer;
    private String operating_system;
    private int ram;
    private int speed_processor;
    private int vga;
    private int hdd;
    private String jenis;

    public komputer(String nama_komputer, String operating_system, int ram, int speed_processor, int vga, int hdd, String jenis) {
        this.nama_komputer = nama_komputer;
        this.operating_system = operating_system;
        this.ram = ram;
        this.speed_processor = speed_processor;
        this.vga = vga;
        this.hdd = hdd;
        this.jenis = jenis;
    }

    public abstract void spesifikasi();

    public String getNama_komputer() {
        return nama_komputer;
    }

    public String getOperating_system() {
        return operating_system;
    }

    public int getRam() {
        return ram;
    }

    public int getSpeed_processor() {
        return speed_processor;
    }

    public int getVga() {
        return vga;
    }

    public int getHdd() {
        return hdd;
    }

    public String getJenis() {
        return jenis;
    }

}
