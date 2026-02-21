package org.example.services;

import jakarta.servlet.http.HttpServletRequest;

public interface IPService {
    String getRemoteIP(HttpServletRequest request);
}
