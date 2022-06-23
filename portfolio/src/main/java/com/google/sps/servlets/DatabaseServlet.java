package com.google.sps.servlets;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.KeyFactory;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
*/

/** Servlet responsible for taking user info from contact-me */
@WebServlet("/user-info")
public class DatabaseServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    // Sanitize user input to remove HTML tags and JavaScript.
    PortfolioUsers portfolioUsers = new PortfolioUsers(null, null, null, null);

    String fname = portfolioUsers.getFname();
    String lname = portfolioUsers.getLname();
    String subject = portfolioUsers.getSubject();
    String email = portfolioUsers.getEmail();

    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("Task");
    FullEntity taskEntity =
        Entity.newBuilder(keyFactory.newKey())
            .set("fname", fname)
            .set("lname", lname)
            .set("subject", subject)
            .set("email", email)
            .build();
    datastore.put(taskEntity);

    response.sendRedirect("/index.html");
  }
}