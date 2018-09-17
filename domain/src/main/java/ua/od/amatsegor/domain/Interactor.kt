package ua.od.amatsegor.domain

import ua.od.amatsegor.data.Repo
import ua.od.amatsegor.domain.entity.DomainUserEntity
import ua.od.amatsegor.domain.mapper.DomainUserMapper
import io.reactivex.Single

class Interactor(private val repo: Repo) {

    operator fun invoke(): Single<List<DomainUserEntity>> {
        return repo.getUserRx().flatMap { list ->
            Single.just(list.map { DomainUserMapper.map(it) })
        }
    }
}