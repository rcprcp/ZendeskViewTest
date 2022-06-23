package com.cottagecoders.zendeskviewtest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zendesk.client.v2.Zendesk;
import org.zendesk.client.v2.ZendeskResponseException;
import org.zendesk.client.v2.model.Ticket;
import org.zendesk.client.v2.model.View;

public class ZendeskViewTest {
  private static final Logger LOG = LoggerFactory.getLogger(ZendeskViewTest.class);

  public static void main(String[] args) {
    ZendeskViewTest zvt = new ZendeskViewTest();
    zvt.run();
  }

  private void run() {

    String id = System.getenv("ZENDESK_ID");
    String token = System.getenv("ZENDESK_TOKEN");
    try (Zendesk zd = new Zendesk.Builder("https://streamsets.zendesk.com").setUsername(id).setToken(token).setRetry(
        false).build()) {

      try {
        for (View v : zd.getViews()) {
          System.out.println("View: " + v);
          for (Ticket t : zd.getView(v.getId())) {
            System.out.println("Ticket: " + t);
          }
        }
      } catch (ZendeskResponseException ex) {
        System.out.println("Exception: " + ex.getMessage());
        ex.printStackTrace();
      }
    }
  }
}
