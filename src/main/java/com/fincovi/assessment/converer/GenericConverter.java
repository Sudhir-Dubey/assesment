package com.fincovi.assessment.converer;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public interface GenericConverter<D, R> {

    D toDomain(R resource);

    R toResource(D domain);

    default List domainsToResources(final Collection<D> domains) {
        return domains.stream().map(this::toResource).collect(Collectors.toList());
    }

    default List ResourcesToDomain(final Collection<R> resources) {
        return resources.stream().map(this::toDomain).collect(Collectors.toList());
    }
}
