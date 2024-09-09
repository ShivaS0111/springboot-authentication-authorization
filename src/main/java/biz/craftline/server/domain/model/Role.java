package biz.craftline.server.domain.model;


import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    /*@ManyToMany(mappedBy = "roles")
    private Set<User> users;*/

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role_permissions", 
               joinColumns = @JoinColumn(name = "role_id"), 
               inverseJoinColumns = @JoinColumn(name = "permission_id"))
    private Set<Permission> permissions;

    // Getters and setters
}
