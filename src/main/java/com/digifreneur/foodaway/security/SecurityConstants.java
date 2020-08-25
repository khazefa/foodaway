package com.digifreneur.foodaway.security;

public final class SecurityConstants {

    private SecurityConstants() {
        throw new IllegalStateException("Utility class");
      }

    static final String SECRET = "IKnowWhatYouDidLastSummerBray";
    static final String TOKEN_PREFIX = "Bearer ";
    static final String HEADER_STRING = "Authorization";
    static final String SIGN_UP_URL = "/users/sign-up";
    static final long EXPIRATION_TIME = 864_000_000; // 10 days
}