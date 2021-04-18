package com.crosssolutions.user.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import lombok.Getter;
import lombok.Setter;

/**
 * Application Table, holds informations about declared applications in Master Key
 *
 * @author Duc.Nguyen
 */
@Getter
@Setter
@Entity
@Table(name = "T_APPLICATION")
public class Application extends AbstractAuditingEntity {

    /** serialVersionUID */
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "APP_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /** Application Id */
    private Long id;

    /** Application Name */
    @Column(name = "APP_NAME")
    private String name;

    /** Application Description */
    @Column(name = "APP_DESCRIPTION")
    private String description;

    /** Application Unique Id */
    @Column(name = "APP_HASH_ID")
    private String appId;

    @ManyToMany(mappedBy = "applications")
    private Set<User> users;

    /**
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).toHashCode();
    }

    /**
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object obj) {

        if (this == obj) {
            return true;
        }

        final Application other = (Application) obj;

        return new EqualsBuilder().append(id, other.id).isEquals();
    }
}
