package controllers;

public interface Controller {

    boolean hasCategory(String category);

    boolean hasPermission(String category, String permission);

    boolean hasEmployeeName(String category);
}
