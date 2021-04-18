package com.crosssolutions.user.service.exception;

import java.net.URI;

public interface ErrorConstants {

    String PROBLEM_BASE_URL = "https://www.order-review.vn/problem";

    URI DEFAULT_TYPE = URI.create(PROBLEM_BASE_URL + "/problem-with-message");
}
