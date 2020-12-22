package controllers;

import models.Client;

public interface Controller {

    boolean hasCategory(String category);

    boolean hasPermission(String category, String permission);


    boolean hasEmployerName(String category);

    int registerEmployer(String category, String permission, String employerName);

    boolean hasClient(String clientName);

    boolean hasLocationId(int locationId);

    boolean hasClientID(int clientId);

    Client getClient(int clientId);

    int registerClient(String clientName);

    int registerItem(String n);

    boolean hasItem(int itemId);
}
