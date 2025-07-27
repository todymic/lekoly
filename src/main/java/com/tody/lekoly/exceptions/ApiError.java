package com.tody.lekoly.exceptions;

import java.time.LocalDateTime;

public record ApiError(LocalDateTime timestamp, String message, int status, String error) {
}
