package com.gauravlad.gridweaver_backend.config;

import com.gauravlad.gridweaver_backend.enums.BatteryEvent;
import com.gauravlad.gridweaver_backend.enums.BatteryState;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;

@Configuration
@EnableStateMachine
public class BatteryStateMachineConfig
        extends StateMachineConfigurerAdapter<BatteryState, BatteryEvent> {

    @Override
    public void configure(
            StateMachineStateConfigurer<BatteryState, BatteryEvent> states)
            throws Exception {

        states
                .withStates()
                .initial(BatteryState.IDLE)
                .state(BatteryState.CHARGING)
                .state(BatteryState.DISCHARGING)
                .state(BatteryState.FAULT);
    }
}