package frontend.controllers;

import backend.entities.UsersEntity;
import frontend.main.MainClass;

public class Mediator {
    private LoginController loginController;
    private DataInputController dataInputController;
    private MainClass mainClass;

    public Mediator(MainClass mainClass, LoginController loginController, DataInputController dataInputController) {
        this.mainClass = mainClass;
        this.loginController = loginController;
        this.dataInputController = dataInputController;
        loginController.setMediator(this);
        dataInputController.setMediator(this);
    }

    public void showDataInput(UsersEntity user) {
        dataInputController.setUser(user);
        mainClass.showDataInput();
    }
}
