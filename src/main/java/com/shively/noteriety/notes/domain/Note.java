package com.shively.noteriety.notes.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * User: devinshively
 * Created On: 9/22/14 4:07 PM
 */
@Entity(name="Notes")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String note;
    private Date createdDate;
    private Date modifiedDate;
    private Long createdBy;
    private Long modifiedBy;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="note_hash",
               joinColumns = {@JoinColumn(name="note_id", referencedColumnName = "id")},
               inverseJoinColumns={@JoinColumn(name="hash_id", referencedColumnName = "id")})
    private Set<Hash> hashes = new HashSet<Hash>();

    public Note() {}
    public Note(Long id, String title, String note, Date createdDate, Date modifiedDate,
                Long createdBy, Long modifiedBy) {
        this.id = id;
        this.title = title;
        this.note = note;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Long getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Long modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Set<Hash> getHashes() {
        return hashes;
    }

    public void setHashes(Set<Hash> hashes) {
        this.hashes = hashes;
    }
}
