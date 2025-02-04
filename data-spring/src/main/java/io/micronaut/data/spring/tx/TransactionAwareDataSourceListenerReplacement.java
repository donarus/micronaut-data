/*
 * Copyright 2017-2021 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micronaut.data.spring.tx;

import io.micronaut.context.annotation.Replaces;
import io.micronaut.context.event.BeanCreatedEvent;
import io.micronaut.context.event.BeanCreatedEventListener;
import io.micronaut.core.annotation.Internal;
import io.micronaut.jdbc.spring.DataSourceTransactionManagerFactory;

import jakarta.inject.Singleton;
import javax.sql.DataSource;

/**
 * Disables the transaction aware listener provided by DataSourceTransactionManagerFactory.
 *
 * @author graemerocher
 * @since 2.2.2
 */
@Singleton
@Internal
@Replaces(factory = DataSourceTransactionManagerFactory.class, bean = BeanCreatedEventListener.class)
final class TransactionAwareDataSourceListenerReplacement implements BeanCreatedEventListener<DataSource> {
    @Override
    public DataSource onCreated(BeanCreatedEvent<DataSource> event) {
        return event.getBean();
    }
}
