package com.epam.testAutomationLab.homeWork.Exception;

public class SpaceUsageTooMuchException extends Exception {
    @Override
    public String toString() {
        return "Space usage should be less than 70% of Room area.";
    }
}
