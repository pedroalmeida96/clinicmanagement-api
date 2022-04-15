package com.pedroalmeida.shared;

public class Mappings {
    public static final String API = "/api";

    public static final String GET_ALL_APPOINTMENTS = "/appointments";
    public static final String GET_APPOINTMENTS_BY_ID = "/appointments/{id}";
    public static final String ADD_APPOINTMENT = "/add";
    public static final String DELETE_APPOINTMENT = "/delete/{id}";
    public static final String UPDATE_APPOINTMENT = "/patch";

    public static final String GET_ALL_DOCTORS = "/doctors";
    public static final String GET_DOCTOR_BY_ID = "/doctors/{id}";
    public static final String ADD_DOCTOR = "/doctors/add";
    public static final String DELETE_DOCTOR = "/doctors/delete/{id}";
    public static final String UPDATE_DOCTOR = "/doctors/patch";

    public static final String GET_ALL_PATIENTS = "/patients";
    public static final String GET_PATIENTS_BY_ID = "/patients/{id}";
    public static final String ADD_PATIENTS = "/patients/add";
    public static final String DELETE_PATIENTS = "/patients/delete/{id}";
    public static final String UPDATE_PATIENTS = "/patients/patch";
}
