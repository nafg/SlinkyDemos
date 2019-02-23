package demo

import typings.atAngularCoreLib.atAngularCoreMod.{^ => Core}
import typings.atAngularCoreLib.srcMetadataNgUnderscoreModuleMod.NgModule
import typings.atAngularCoreLib.srcTypeMod.Type
import typings.atAngularRouterLib.atAngularRouterMod.RouterModule
import typings.atAngularRouterLib.srcConfigMod.{Route, Routes}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExportStatic
import scala.scalajs.js.|

final class AppRoutingModule extends js.Object

object AppRoutingModule {

  @JSExportStatic
  val annotations =
    js.Array(
      Core.NgModule.newInstance1(
        NgModule(
          imports = js.Array[Import](unspecify(RouterModule.forRoot(routes))),
          exports = js.Array[Type[_] | js.Array[_]](typeOf[RouterModule])
        )
      )
    )

  def routes: Routes = js.Array(
    Route(
      path      = "heroes",
      component = typeOf[heroeditor.HeroesComponent]
    ),
    Route(
      path      = "dashboard",
      component = typeOf[heroeditor.DashboardComponent]
    ),
    Route(
      path       = "",
      redirectTo = "/dashboard",
      pathMatch  = "full"
    ),
    Route(
      path      = "detail/:id",
      component = typeOf[heroeditor.HeroDetailComponent]
    )
  )
}
