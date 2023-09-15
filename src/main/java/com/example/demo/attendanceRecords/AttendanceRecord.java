package com.example.demo.attendanceRecords;

import com.example.demo.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Entity
@Getter
@RequiredArgsConstructor
@NoArgsConstructor // TODO: remove after testing (not safe)
@ToString
public class AttendanceRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id", nullable = false)
    @NonNull
    private User employee;

    @Setter
    @NotNull(message = "Sign in timestamp cannot be null")
    @PastOrPresent
    @NonNull
    private LocalDateTime signInTimestamp;

    @PastOrPresent
    private LocalDateTime signOutTimestamp;

    private Long attendedHoursCount;

    public void setSignOutTimestamp(LocalDateTime signOutTimestamp) throws IllegalArgumentException {
        // if the sign-out happened before the sign-in or at the same time as the sign-in
        if (signOutTimestamp.isBefore(signInTimestamp) || signOutTimestamp.isEqual(signInTimestamp)) {
            throw new IllegalArgumentException("Sign out timestamp must be after Sign in timestamp");
        }
        this.attendedHoursCount = this.signInTimestamp.until(signOutTimestamp, ChronoUnit.HOURS);
        this.signOutTimestamp = signOutTimestamp;
    }
}
