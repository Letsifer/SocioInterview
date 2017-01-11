package edu.altstu.sociointerview.entities;

import java.io.Serializable;
import javax.persistence.MappedSuperclass;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author gea
 */
@Getter
@Setter
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public abstract class BasicEntity<T extends Serializable> implements Serializable{

    @Id
    T id;

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }
    
}
