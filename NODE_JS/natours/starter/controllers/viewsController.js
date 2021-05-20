/**
 * Views Controller || Takes care of the main functionality of how the views should work
 */
const Tour = require('../model/tourModel');
const catchAsync = require('../utils/catchAsync');

/**
 * Get all the tour data from collection and pass it into the template || Build template || Render the template using the tour data
 * @param {*} req
 * @param {*} res
 */
exports.getOverview = catchAsync(async (req, res) => {
  const tours = await Tour.find();

  res.status(200).render('overview', {
    title: 'All tours',
    tours,
  });
});

exports.getTour = catchAsync(async (req, res) => {
  const tour = await (
    await Tour.findOne({ slug: req.params.slug })
  )
    .populate({
      path: 'reviews',
      fields: 'review rating user',
    })
    .execPopulate();

  res
    .status(200)
    .set(
      'Content-Security-Policy',
      "default-src 'self' https://*.mapbox.com ;base-uri 'self';block-all-mixed-content;font-src 'self' https: data:;frame-ancestors 'self';img-src 'self' data:;object-src 'none';script-src https://cdnjs.cloudflare.com https://api.mapbox.com 'self' blob: ;script-src-attr 'none';style-src 'self' https: 'unsafe-inline';upgrade-insecure-requests;"
    )
    .render('tour', {
      title: `${tour.name} Tour`,
      tour,
    });
});
