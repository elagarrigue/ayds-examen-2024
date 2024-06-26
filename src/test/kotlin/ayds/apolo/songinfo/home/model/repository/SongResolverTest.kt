package ayds.apolo.songinfo.home.model.repository

import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test


class ExampleTests {

    interface Dependency {
        fun sideEffect()
    }

    class Example(private val dependency: Dependency) {
        fun test1(num: Int) = num * num

        fun test2() = dependency.sideEffect()
    }

    @Test
    fun `test 1`() {
        val example = Example(mockk())

        val result = example.test1(2)

        Assertions.assertEquals(4, result)
    }

    @Test
    fun `test 2`() {
        val dependency: Dependency = mockk(relaxUnitFun = true)
        val example = Example(dependency)

        example.test2()

        verify { dependency.sideEffect() }
    }
}