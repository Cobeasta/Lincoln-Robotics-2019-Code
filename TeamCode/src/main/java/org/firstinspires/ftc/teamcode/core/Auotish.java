package org.firstinspires.ftc.teamcode.core;

import org.firstinspires.ftc.teamcode.core.commands.TestChassis;

public class Auotish extends Auto {
    @Override
    public void addCommands() {
        addSequential(new TestChassis());
    }
}
