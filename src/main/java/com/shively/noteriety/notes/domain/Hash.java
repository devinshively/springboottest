package com.shively.noteriety.notes.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * User: devinshively
 * Created On: 9/22/14 4:08 PM
 */
@Entity(name="Hashes")
public class Hash {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "hashes")
    private Set<Note> notes = new HashSet<Note>();

    Hash() {}
    Hash(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Note> getNotes() {
        return notes;
    }

    public void setNotes(Set<Note> notes) {
        this.notes = notes;
    }
}
