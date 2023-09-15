package com.example.demo.user;

import com.example.demo.attendanceRecords.AttendanceRecord;
import com.example.demo.role.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.Set;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor // TODO: remove after testing (not safe)
@Getter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @NotBlank(message = "Name cannot be empty")
    @NonNull
    private String name;

    @Setter
    @Past
    private LocalDate dateOfBirth;

    @Setter
    @Column(unique = true)
    @NotBlank(message = "Phone Number cannot be empty")
    @NonNull
    private String phoneNumber;

    @Setter
    @Email
    private String email;

    @Setter
    @NotBlank(message = "Password cannot be empty")
    @NonNull
    private String password;


    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Set<AttendanceRecord> attendanceRecords;

    @ManyToMany(mappedBy = "users", fetch = FetchType.EAGER)
    @NotEmpty(message = "Roles cannot be empty")
    @NonNull
    private Set<Role> roles;
}
