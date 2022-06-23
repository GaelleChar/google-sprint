package com.google.sps.servlets;

public final class PortfolioUsers {

  private final String fname;
  private final String lname;
  private final String subject;
  private final String email;

  public PortfolioUsers(String fname, String lname, String subject, String email) {
    this.fname = fname;
    this.lname = lname;
    this.subject = subject;
    this.email = email;
  }

  public String getFname() {
    return fname;
  }

  public String getLname() {
    return lname;
  }

  public String getSubject() {
    return subject;
  }

  public String getEmail() {
    return email;
  }
  public String getServletInfo() {
    return null;
  }
}