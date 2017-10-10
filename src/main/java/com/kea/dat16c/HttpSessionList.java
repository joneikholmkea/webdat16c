package com.kea.dat16c;

import java.util.HashMap;
import java.util.Map;

public class HttpSessionList {
   private static Map<String, String> sessionsMap = new HashMap();

   public synchronized static Map<String, String> getSessionsMap() {
      return sessionsMap;
   }

   public synchronized static void addToMap(String session, String username){
      sessionsMap.put(session, username);
   }

   //returns null if user doesn't have session id, returns username if already logged in.
   public synchronized static String searchMap(String session){
      return sessionsMap.get(session);
   }

   public synchronized static void removeKey(String key){
      sessionsMap.remove(key);
   }
}
