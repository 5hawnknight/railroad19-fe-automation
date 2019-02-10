package com.rr19.library.selenium.waits;

public enum TimeOut {
    ONE_SECOND,
    FIVE_SECONDS,
    TEN_SECONDS,
    FIFTEEN_SECONDS,
    THIRTY_SECONDS,
    SIXTY_SECONDS,
    NINETY_SECONDS,
    HUNDRED_TWENTY_SECONDS,
    DEFAULT;

    public static Long of(TimeOut margin)
    {
        switch (margin)
        {
            case ONE_SECOND: return 1L;
            case FIVE_SECONDS: return 5L;
            case TEN_SECONDS: return 10L;
            case FIFTEEN_SECONDS: return 15L;
            case THIRTY_SECONDS: return 30L;
            case SIXTY_SECONDS: return 60L;
            case NINETY_SECONDS: return 90L;
            case HUNDRED_TWENTY_SECONDS: return 120L;
            default: return of(SIXTY_SECONDS);
        }
    }
}