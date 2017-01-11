package edu.altstu.sociointerview.entities;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author gea
 */
@Getter
@Setter
public abstract class BasicEntity<T> {
    T id;
}
