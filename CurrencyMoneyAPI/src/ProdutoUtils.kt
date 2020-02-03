import java.math.BigDecimal

object ProdutoUtils {

    //fun List<Produto>.mesmaMoeda(moeda: Moeda) : List<Produto> = this.filter { it.moeda == moeda }

    @JvmStatic
    fun soma(produtos: List<Produto>, moeda: Moeda) : BigDecimal {
        var acc = BigDecimal.ZERO
        //produtos.mesmaMoeda(moeda).forEach {}
        return acc
    }
}