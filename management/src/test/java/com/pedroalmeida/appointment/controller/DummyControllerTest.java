package com.pedroalmeida.appointment.controller;

import com.pedroalmeida.shared.DummyController;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class DummyControllerTest {

    @Test
    void welcome() {
        DummyController dummyController = new DummyController();
        assertThat(dummyController).isNotNull();
    }
}